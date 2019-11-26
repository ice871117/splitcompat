package com.google.android.play.core.tasks;

import com.google.android.play.core.tasks.OnCompleteListener;
import com.google.android.play.core.tasks.OnFailureListener;
import com.google.android.play.core.tasks.OnSuccessListener;
import java.util.concurrent.Executor;

public abstract class Task {

   // $FF: renamed from: <init> () void
   public void method_155() {
      super();
   }

   public abstract boolean isComplete();

   public abstract boolean isSuccessful();

   public abstract Object getResult();

   public abstract Object getResult(Class var1) throws Throwable;

   public abstract Exception getException();

   public abstract Task addOnSuccessListener(OnSuccessListener var1);

   public abstract Task addOnSuccessListener(Executor var1, OnSuccessListener var2);

   public abstract Task addOnFailureListener(OnFailureListener var1);

   public abstract Task addOnFailureListener(Executor var1, OnFailureListener var2);

   public abstract Task addOnCompleteListener(OnCompleteListener var1);

   public abstract Task addOnCompleteListener(Executor var1, OnCompleteListener var2);
}
