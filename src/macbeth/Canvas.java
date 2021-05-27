package macbeth;

import java.util.Scanner;

public class Canvas {

    public static void main(String[] args) {
        HTTPHelper httpHelper = new HTTPHelper();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Canvas API Demo");
        System.out.println("==================");

        // Each user can get their own Canvas Token by going to:
        // https://byui.instructure.com/profile/settings
        // and selecting "New Access Token".  Only do this one and
        // copy the token somewhere so you can reference it again.
        // You won't be able to see the token again in Canvas
        // unless you create another one.

        System.out.println("Enter your Canvas Token: ");
        String token = scanner.nextLine();

        // Find Canvas API here:  https://canvas.instructure.com/doc/api/

        // Show student courses (https://canvas.instructure.com/doc/api/courses.html#method.courses.index)
        String result = httpHelper.readHTTP("https://canvas.instructure.com/api/v1/courses", "Bearer "+token);
        System.out.println("JSON Output for Courses:");
        System.out.println(result);

        // Show student assignments for course (https://canvas.instructure.com/doc/api/assignments.html#method.assignments_api.index)
        System.out.println("Enter the course ID you want assignments for (look at output above): ");
        String courseID = scanner.nextLine();
        result = httpHelper.readHTTP("https://canvas.instructure.com/api/v1/courses/"+courseID+"/assignments", "Bearer "+token);
        System.out.println("JSON Output for Assignments of that Course:");
        System.out.println(result);


    }


}
