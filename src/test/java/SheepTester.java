import org.junit.jupiter.api.Test;
import java.lang.reflect.*;

import com.incorta.observability.java.reflection.Sheep;

public class SheepTester {

    @Test
    public void getFields() throws IllegalAccessException {
        Sheep firstSheep = new Sheep("007", "5aroofna", "el ghada", 50.0, "el team");
        Class sheepClass = firstSheep.getClass();
        Field[] sheepFields = sheepClass.getDeclaredFields();
        for (Field field : sheepFields) {
            boolean canAccess = field.canAccess(firstSheep);

            System.out.println(field);
            System.out.println(Modifier.toString(field.getModifiers())+ " - modifier as int: " + field.getModifiers() + ", Can access:" + canAccess);
            if (canAccess) {
                System.out.println("field value:" + field.get(firstSheep));
            }
            field.setAccessible(true);


            if (!canAccess) {
                System.out.println("Trying to set field accessible status:" + (field.trySetAccessible() ? "Success" : "fail"));
                System.out.println("After setting accessible -> field value:" + field.get(firstSheep));
            }
            System.out.println();
        }

    }

    @Test
    public void getConstructors() {
        Class<?> sheepClass = null;
        try {
            sheepClass = Class.forName("com.incorta.observability.java.reflection.Sheep");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Constructor<?>[] constructors = sheepClass.getConstructors();
        for (Constructor c : constructors) {
            System.out.println(c);
        }

        Class<?>[] parameterClasses = {String.class, String.class, String.class, double.class, String.class};
        Constructor<?> cons = null;
        try {
            cons = sheepClass.getConstructor(parameterClasses);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        Object[] actualParameters = {"007", "5aroofna", "el ghada", 50.0, "el team"};
        try {
            Object sheepFromReflection = cons.newInstance(actualParameters);
            Sheep castedSheep = (Sheep) sheepFromReflection;
            System.out.println(castedSheep);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void invokeMethod() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class sheepClass = Class.forName("com.incorta.observability.java.reflection.Sheep");
        Method eatMethod = sheepClass.getDeclaredMethod("eats");
        Sheep invokeThisSheep = new Sheep("008", "5aroof Alice", "best fatta", 60.0, "Alice");
        eatMethod.invoke(invokeThisSheep);
    }
}
