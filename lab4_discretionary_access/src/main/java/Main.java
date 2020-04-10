import java.util.*;

public class Main {
    public static void main(String[] args) {

        // add system objects
        List<SystemObject> objects = new ArrayList<SystemObject>();
        SystemObject ob1 = new SystemObject(1, "Object_1");
        SystemObject ob2 = new SystemObject(2, "Object_2");
        SystemObject ob3 = new SystemObject(3, "Object_3");
        SystemObject ob4 = new SystemObject(4, "Object_4");

        // add users
        ArrayList<User> users = new ArrayList<User>();

        // create maps
        HashMap<SystemObject, AccessTypes> mapAdmin = new HashMap<SystemObject, AccessTypes>();
        mapAdmin.put(ob1, AccessTypes.FULL_ACCESS);
        mapAdmin.put(ob2, AccessTypes.FULL_ACCESS);
        mapAdmin.put(ob3, AccessTypes.FULL_ACCESS);
        mapAdmin.put(ob4, AccessTypes.FULL_ACCESS);

        User user1 = new User(1, "user1", Role.ADMIN, mapAdmin);
        users.add(user1);

        // add rights for each user to each object
        for (int i = 2; i <= 5; i++) {
            HashMap<SystemObject, AccessTypes> map = new HashMap<SystemObject, AccessTypes>();

            map.put(ob1, AccessTypes.randomAccessType());
            map.put(ob2, AccessTypes.randomAccessType());
            map.put(ob3, AccessTypes.randomAccessType());
            map.put(ob4, AccessTypes.randomAccessType());

            User u = new User(i, "user" + i, Role.USER, map);
            users.add(u);
        }

        Scanner sc = new Scanner(System.in);
        String waiting = "Жду ваших указаний > ";

        // Step1 : identification
        System.out.println("User: ");
        String currentUser = sc.next();

        boolean fl = false;
        for (User u : users) {
            if (u.getName().equals(currentUser)) {
                fl = true;
            }
        }
        if (fl) {
            System.out.println("Идентификация прошла успешно, добро пожаловать в систему!\n" +
                    "Перечень Ваших прав:");

            // get rights of current user for each system object
            for (User u : users) {
                if (u.getName().equals(currentUser)) {
                    for (Map.Entry<SystemObject, AccessTypes> entry : u.getObjectsRoles().entrySet()) {
                        System.out.println(entry.getKey() + " : " + entry.getValue().toString());
                    }
                }
            }

            System.out.println(waiting);
            String action = sc.next();

            SystemObject systemObject = null;
            AccessTypes accessType = null;

            while (!action.equals("quit")) {

                switch (action) {
                    case "read":
                        System.out.println("Над каким объектом производится операция?");
                        int s = sc.nextInt();

                        switch (s) {
                            case 1:
                                systemObject =  ob1;
                                break;
                            case 2:
                                systemObject =  ob2;
                                break;
                            case 3:
                                systemObject =  ob3;
                                break;
                            case 4:
                                systemObject =  ob4;
                                break;
                            default:
                                System.err.println("Такого объекта не существует");
                                break;
                        }

                        // get the object by id
                        for (User u : users) {
                            if (u.getName().equals(currentUser)) {
                                accessType = u.getObjectsRoles().get(systemObject);
                                break;
                            }
                        }

                        if (accessType == AccessTypes.FULL_ACCESS || accessType == AccessTypes.READING || accessType == AccessTypes.READING_AND_WRITING
                                || accessType == AccessTypes.READING_AND_TRANSFER_OF_RIGHTS) {
                            System.out.println("Операция прошла успешно");
                        } else {
                            System.out.println("Отказ в выполнении операции. У Вас нет прав для ее осуществления");
                        }
                        break;

                    case "write":
                        System.out.println("Над каким объектом производится операция?");
                        s = sc.nextInt();

                        switch (s) {
                            case 1:
                                systemObject =  ob1;
                                break;
                            case 2:
                                systemObject =  ob2;
                                break;
                            case 3:
                                systemObject =  ob3;
                                break;
                            case 4:
                                systemObject =  ob4;
                                break;
                            default:
                                System.err.println("Такого объекта не существует");
                                break;
                        }

                        for (User u : users) {
                            if (u.getName().equals(currentUser)) {
                                accessType = u.getObjectsRoles().get(systemObject);
                                break;
                            }
                        }

                        if (accessType == AccessTypes.FULL_ACCESS || accessType == AccessTypes.WRITING || accessType == AccessTypes.READING_AND_WRITING
                        || accessType == AccessTypes.WRITING_AND_TRANSFER_OF_RIGHTS) {
                            System.out.println("Операция прошла успешно");
                        } else {
                            System.out.println("Отказ в выполнении операции. У Вас нет прав для ее осуществления");
                        }
                        break;
                    case "grant":
                        System.out.println("Право на какой объект передается?");
                        s = sc.nextInt();

                        switch (s) {
                            case 1:
                                systemObject =  ob1;
                                break;
                            case 2:
                                systemObject =  ob2;
                                break;
                            case 3:
                                systemObject =  ob3;
                                break;
                            case 4:
                                systemObject =  ob4;
                                break;
                            default:
                                System.err.println("Такого объекта не существует");
                                break;
                        }

                        for (User u : users) {
                            if (u.getName().equals(currentUser)) {
                                accessType = u.getObjectsRoles().get(systemObject);
                                break;
                            }
                        }

                        if (accessType == AccessTypes.FULL_ACCESS || accessType == AccessTypes.READING_AND_TRANSFER_OF_RIGHTS || accessType == AccessTypes.WRITING_AND_TRANSFER_OF_RIGHTS
                                || accessType == AccessTypes.GRANT_RIGHTS) {
                            System.out.println("Операция прошла успешно");
                        } else {
                            System.out.println("Отказ в выполнении операции. У Вас нет прав для ее осуществления");
                        }
                        break;
                    default:
                        System.out.println("Неверная операция. Попробуйте снова");
                        break;

                }

                System.out.println(waiting);
                action = sc.next();
            }

            System.out.println("Работа пользователя " + currentUser + " завершена. До свидания");

        } else {
            System.out.println("Такого пользователя нет в базе, до свидания");
        }
    }
}
