package com.google.android.play.core.internal;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;

public class ba<T> {
    private final Object a;
    private final Field b;
    private final Class<T> c;

    ba(Object obj, Field field, Class<T> cls) {
        this.a = obj;
        this.b = field;
        this.c = cls;
    }

    ba(Object obj, Field field, Class<T> cls, byte b2) {
        this(obj, field, a(cls));
    }

    private static <T> Class<T[]> a(Class<T> cls) {
        return Array.newInstance(cls, 0).getClass();
    }

    private Class<T> b() {
        return this.b.getType().getComponentType();
    }

    public final T a() {
        try {
            return this.c.cast(this.b.get(this.a));
        } catch (Exception e) {
            throw new bb(String.format("Failed to get value of field %s of type %s on object of type %s", new Object[]{this.b.getName(), this.a.getClass().getName(), this.c.getName()}), e);
        }
    }

    public final void a(T t) {
        try {
            this.b.set(this.a, t);
        } catch (Exception e) {
            throw new bb(String.format("Failed to set value of field %s of type %s on object of type %s", new Object[]{this.b.getName(), this.a.getClass().getName(), this.c.getName()}), e);
        }
    }

    public void a(Collection<T> collection) {
        Object[] objArr = (Object[]) a();
        int length = objArr == null ? 0 : objArr.length;
        Object[] objArr2 = (Object[]) Array.newInstance(b(), collection.size() + length);
        if (objArr != null) {
            System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        }
        for (T t : collection) {
            objArr2[length] = t;
            length++;
        }
        a((T) objArr2);
    }

    public void a(T[] tArr) {
        a((Collection<T>) Arrays.asList(tArr));
    }

    public void b(Collection<T> collection) {
        int i = 0;
        Object[] objArr = (Object[]) a();
        Object[] objArr2 = (Object[]) Array.newInstance(b(), (objArr == null ? 0 : objArr.length) + collection.size());
        if (objArr != null) {
            System.arraycopy(objArr, 0, objArr2, collection.size(), objArr.length);
        }
        for (T t : collection) {
            objArr2[i] = t;
            i++;
        }
        a((T) objArr2);
    }

    public void b(T[] tArr) {
        b((Collection<T>) Arrays.asList(tArr));
    }
}
