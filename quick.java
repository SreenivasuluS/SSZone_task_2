import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class Quiz {
    private String question;
    private String answer;

    public Quiz(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}

public class QuickPlatform {
    private static Map<String, User> users = new HashMap<>();
    private static Map<String, Quiz> quizzes = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Dummy user creation
        users.put("user1", new User("user1", "password1"));
        users.put("user2", new User("user2", "password2"));

        // Dummy quiz creation
        quizzes.put("1", new Quiz("What is 2 + 2?", "4"));
        quizzes.put("2", new Quiz("What is the capital of France?", "Paris"));

        System.out.println("Welcome to QuickPlatform!");

        // User authentication
        User currentUser = authenticate(scanner);
        if (currentUser == null) {
            System.out.println("Authentication failed. Exiting...");
            return;
        }

        System.out.println("Authentication successful. Welcome, " + currentUser.getUsername() + "!");

        // Quiz functionality
        System.out.println("Choose a quiz to take:");
        System.out.println("1. Math Quiz");
        System.out.println("2. Geography Quiz");

        String choice = scanner.nextLine();
        Quiz selectedQuiz = quizzes.get(choice);
        if (selectedQuiz == null) {
            System.out.println("Invalid choice. Exiting...");
            return;
        }

        System.out.println(selectedQuiz.getQuestion());
        String userAnswer = scanner.nextLine();

        if (userAnswer.equalsIgnoreCase(selectedQuiz.getAnswer())) {
            System.out.println("Correct answer!");
        } else {
            System.out.println("Incorrect answer.");
        }
    }

    private static User authenticate(Scanner scanner) {
        System.out.println("Please enter your username:");
        String username = scanner.nextLine();
        System.out.println("Please enter your password:");
        String password = scanner.nextLine();

        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }
}
