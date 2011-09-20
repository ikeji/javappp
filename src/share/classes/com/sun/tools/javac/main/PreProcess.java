package com.sun.tools.javac.main;

import com.sun.tools.javac.tree.JCTree.JCCompilationUnit;

public abstract class PreProcess {
  public abstract JCCompilationUnit process(JCCompilationUnit tree);
}
