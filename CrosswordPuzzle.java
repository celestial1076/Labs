import java.util.*;

public class CrosswordPuzzle {
    private char[][] grid;
    private int size;
    private List<String> words;

    public CrosswordPuzzle(int size, List<String> words) {
        this.size = size;
        this.words = words;
        this.grid = new char[size][size];
        initializeGrid();
    }

    private void initializeGrid() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = '-';
            }
        }
    }

    public boolean generateCrossword() {
        for (String word : words) {
            if (!placeWord(word)) {
                return false;
            }
        }
        return true;
    }

    private boolean placeWord(String word) {
        List<int[]> possiblePositions = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= size - word.length(); j++) {
                boolean canPlace = true;
                for (int k = 0; k < word.length(); k++) {
                    if (grid[i][j + k] != '-' && grid[i][j + k] != word.charAt(k)) {
                        canPlace = false;
                        break;
                    }
                }
                if (canPlace) {
                    possiblePositions.add(new int[]{i, j, 0});
                }
            }
        }

        for (int i = 0; i <= size - word.length(); i++) {
            for (int j = 0; j < size; j++) {
                boolean canPlace = true;
                for (int k = 0; k < word.length(); k++) {
                    if (grid[i + k][j] != '-' && grid[i + k][j] != word.charAt(k)) {
                        canPlace = false;
                        break;
                    }
                }
                if (canPlace) {
                    possiblePositions.add(new int[]{i, j, 1});
                }
            }
        }

        if (possiblePositions.isEmpty()) {
            return false;
        }

        Random random = new Random();
        int[] position = possiblePositions.get(random.nextInt(possiblePositions.size()));
        int row = position[0];
        int col = position[1];
        int direction = position[2];

        if (direction == 0) {
            for (int k = 0; k < word.length(); k++) {
                grid[row][col + k] = word.charAt(k);
            }
        } else {
            for (int k = 0; k < word.length(); k++) {
                grid[row + k][col] = word.charAt(k);
            }
        }

        return true;
    }

    public void printCrossword() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод размера сетки
        System.out.print("Введите размер сетки (например, 10): ");
        int size = scanner.nextInt();
        if (size <= 0) {
            System.out.println("Неверный размер сетки.");
            return;
        }

        List<String> words = new ArrayList<>();
        System.out.print("Введите количество слов: ");
        int wordCount = scanner.nextInt();
        scanner.nextLine();  // Очистка буфера
        for (int i = 0; i < wordCount; i++) {
            System.out.print("Введите слово " + (i + 1) + ": ");
            String word = scanner.nextLine();
            if (word.isEmpty() || word.length() > size) {
                System.out.println("Неверное слово.");
                return;
            }
            words.add(word.toUpperCase());
        }

        CrosswordPuzzle puzzle = new CrosswordPuzzle(size, words);
        if (puzzle.generateCrossword()) {
            System.out.println("Кроссворд успешно сгенерирован:");
            puzzle.printCrossword();
        } else {
            System.out.println("Не удалось разместить все слова в сетке.");
        }
    }
}