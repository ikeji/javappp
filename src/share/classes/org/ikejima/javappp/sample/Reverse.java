package org.ikejima.javappp.sample;

import org.ikejima.javappp.util.TraceVisitor;

import com.sun.tools.javac.main.PreProcess;
import com.sun.tools.javac.tree.JCTree.JCBlock;
import com.sun.tools.javac.tree.JCTree.JCCompilationUnit;

public class Reverse extends PreProcess {
  @Override
  public JCCompilationUnit process(JCCompilationUnit tree) {
    tree.accept(new TraceVisitor() {
      @Override
      public void visitBlock(JCBlock that) {
        that.stats = that.stats.reverse();
        super.visitBlock(that);
      }
    });
    return tree;
  }
}
