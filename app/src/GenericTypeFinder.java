import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericTypeFinder {
    public static void main(String[] args) {
        FloatList list = new FloatList();

        Class actualClass = list.getClass();
        System.out.println("actualClass = " + actualClass);
        Type type = actualClass.getGenericSuperclass();
        System.out.println("actualClass.getGenericSuperclass() = " + type);
        System.out.println("actualClass.getGenericSuperclass().getClass() = " + type.getClass());
        ParameterizedType parameterizedType = (ParameterizedType) type;
        parameterizedType.getRawType();//returns ArrayList
        Type[] types = parameterizedType.getActualTypeArguments();//returns array with 1 argument
        System.out.println("types[0] = " + types[0]);
    }

    //summary method
    public static Class getGenericParameterClass(Class actualClass, int parameterIndex) {
        return (Class) ((ParameterizedType) actualClass.getGenericSuperclass()).getActualTypeArguments()[parameterIndex];
    }
}
