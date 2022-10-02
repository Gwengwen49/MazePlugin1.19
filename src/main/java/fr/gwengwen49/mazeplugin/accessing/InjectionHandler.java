package fr.gwengwen49.mazeplugin.accessing;

import com.google.common.collect.Lists;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;


public class InjectionHandler {


    public static void getAndExecute(Class aClass, String method)
    {
      for (Method method1 : INJECTORS)
      {
          if(method1.getAnnotation(InjectAt.class).value() == aClass)
          {
                if(method1.getAnnotation(InjectAt.class).methodName().equals(method))
                {
                    try {
                        method1.invoke(method1.getAnnotation(InjectAt.class).value().newInstance());

                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    }
                }
          }
      }
    }

    private static List<Method> INJECTORS = new ArrayList<>();

    public static void registerInjectors(Class... classes)
    {
        for(Class aClass : classes)
        {
            for (Method method : aClass.getMethods())
            {
                if(method.isAnnotationPresent(InjectAt.class))
                {
                    INJECTORS.add(method);
                }
            }
        }
    }
}
