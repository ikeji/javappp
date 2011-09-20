package org.ikejima.javappp.sample;

import java.util.Iterator;

import org.ikejima.javappp.util.TraceVisitor;

import com.sun.tools.javac.main.PreProcess;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.JCTree.JCAnnotation;
import com.sun.tools.javac.tree.JCTree.JCArrayAccess;
import com.sun.tools.javac.tree.JCTree.JCArrayTypeTree;
import com.sun.tools.javac.tree.JCTree.JCAssert;
import com.sun.tools.javac.tree.JCTree.JCAssign;
import com.sun.tools.javac.tree.JCTree.JCAssignOp;
import com.sun.tools.javac.tree.JCTree.JCBinary;
import com.sun.tools.javac.tree.JCTree.JCBlock;
import com.sun.tools.javac.tree.JCTree.JCBreak;
import com.sun.tools.javac.tree.JCTree.JCCase;
import com.sun.tools.javac.tree.JCTree.JCCatch;
import com.sun.tools.javac.tree.JCTree.JCClassDecl;
import com.sun.tools.javac.tree.JCTree.JCCompilationUnit;
import com.sun.tools.javac.tree.JCTree.JCConditional;
import com.sun.tools.javac.tree.JCTree.JCContinue;
import com.sun.tools.javac.tree.JCTree.JCDoWhileLoop;
import com.sun.tools.javac.tree.JCTree.JCEnhancedForLoop;
import com.sun.tools.javac.tree.JCTree.JCErroneous;
import com.sun.tools.javac.tree.JCTree.JCFieldAccess;
import com.sun.tools.javac.tree.JCTree.JCForLoop;
import com.sun.tools.javac.tree.JCTree.JCIdent;
import com.sun.tools.javac.tree.JCTree.JCIf;
import com.sun.tools.javac.tree.JCTree.JCImport;
import com.sun.tools.javac.tree.JCTree.JCInstanceOf;
import com.sun.tools.javac.tree.JCTree.JCLabeledStatement;
import com.sun.tools.javac.tree.JCTree.JCLiteral;
import com.sun.tools.javac.tree.JCTree.JCMethodDecl;
import com.sun.tools.javac.tree.JCTree.JCMethodInvocation;
import com.sun.tools.javac.tree.JCTree.JCModifiers;
import com.sun.tools.javac.tree.JCTree.JCNewArray;
import com.sun.tools.javac.tree.JCTree.JCNewClass;
import com.sun.tools.javac.tree.JCTree.JCParens;
import com.sun.tools.javac.tree.JCTree.JCPrimitiveTypeTree;
import com.sun.tools.javac.tree.JCTree.JCReturn;
import com.sun.tools.javac.tree.JCTree.JCSkip;
import com.sun.tools.javac.tree.JCTree.JCSwitch;
import com.sun.tools.javac.tree.JCTree.JCSynchronized;
import com.sun.tools.javac.tree.JCTree.JCThrow;
import com.sun.tools.javac.tree.JCTree.JCTry;
import com.sun.tools.javac.tree.JCTree.JCTypeApply;
import com.sun.tools.javac.tree.JCTree.JCTypeCast;
import com.sun.tools.javac.tree.JCTree.JCTypeParameter;
import com.sun.tools.javac.tree.JCTree.JCTypeUnion;
import com.sun.tools.javac.tree.JCTree.JCUnary;
import com.sun.tools.javac.tree.JCTree.JCVariableDecl;
import com.sun.tools.javac.tree.JCTree.JCWhileLoop;
import com.sun.tools.javac.tree.JCTree.JCWildcard;
import com.sun.tools.javac.tree.JCTree.LetExpr;
import com.sun.tools.javac.tree.JCTree.TypeBoundKind;
import com.sun.tools.javac.tree.JCTree.Visitor;

public class DumpTree extends PreProcess {

  @Override
  public JCCompilationUnit process(JCCompilationUnit tree) {
    tree.accept(new TraceVisitor() {
      int level = 0;
      private void spc(){
        for(int i =0;i<level;i++){
          System.out.print(" ");
        }
      }
      private void pr(String str){
        spc();
        System.out.println(str);
      }
      private void pr(String str, String str2){
        pr(str + ": " + str2);
      }
      
      @Override
      public void visitAnnotation(JCAnnotation that) {
        pr("Annotation");
        level++; super.visitAnnotation(that); level--;
      }
      @Override
      public void visitApply(JCMethodInvocation that) {
        pr("Apply");
        level++; super.visitApply(that); level--;
      }
      @Override
      public void visitAssert(JCAssert that) {
        pr("Assert");
        level++;
        super.visitAssert(that); 
        level--;
      }
      @Override
      public void visitAssign(JCAssign that) {
        pr("Assign");
        level++;
        super.visitAssign(that); 
        level--;
      }
      @Override
      public void visitAssignop(JCAssignOp that) {
        pr("AssignOp");
        level++;
        super.visitAssignop(that); 
        level--;
      }
      @Override
      public void visitBinary(JCBinary that) {
        pr("Binary");
        level++;
        super.visitBinary(that); 
        level--;
      }
      @Override
      public void visitBlock(JCBlock that) {
        pr("Block");
        level++;
        super.visitBlock(that); 
        level--;
      }
      @Override
      public void visitBreak(JCBreak that) {
        pr("Break");
        level++;
        super.visitBreak(that); 
        level--;
      }
      @Override
      public void visitCase(JCCase that) {
        pr("Case");
        level++;
        super.visitCase(that); 
        level--;
      }
      @Override
      public void visitCatch(JCCatch that) {
        pr("Catch");
        level++;
        super.visitCatch(that); 
        level--;
      }
      @Override
      public void visitClassDef(JCClassDecl that) {
        pr("ClassDef", that.name.toString());
        level++;
        super.visitClassDef(that);
        level--;
      }
      @Override
      public void visitConditional(JCConditional that) {
        pr("Conditional");
        level++;
        super.visitConditional(that); 
        level--;
      }
      @Override
      public void visitContinue(JCContinue that) {
        pr("Continue");
        level++;
        super.visitContinue(that); 
        level--;
      }
      @Override
      public void visitDoLoop(JCDoWhileLoop that) {
        pr("DoLoop");
        level++;
        super.visitDoLoop(that); 
        level--;
      }
      @Override
      public void visitErroneous(JCErroneous that) {
        pr("Erroneous");
        level++;
        super.visitErroneous(that); 
        level--;
      }
      @Override
      public void visitExec(com.sun.tools.javac.tree.JCTree.JCExpressionStatement that) {
        pr("Exec", that.expr.toString());
        level++;
        super.visitExec(that); 
        level--;
      }
      @Override
      public void visitForeachLoop(JCEnhancedForLoop that) {
        pr("ForeachLoop");
        level++;
        super.visitForeachLoop(that); 
        level--;
      }
      @Override
      public void visitForLoop(JCForLoop that) {
        pr("ForLoop");
        level++;
        super.visitForLoop(that); 
        level--;
      }
      @Override
      public void visitIdent(JCIdent that) {
        pr("Ident", that.getName().toString());
        level++;
        super.visitIdent(that); 
        level--;
      }
      @Override
      public void visitIf(JCIf that) {
        pr("If");
        level++;
        super.visitIf(that);
        level--;
      }
      @Override
      public void visitImport(JCImport that) {
        pr("Import");
        level++;
        super.visitImport(that); 
        level--;
      }
      @Override
      public void visitIndexed(JCArrayAccess that) {
        pr("Indexed");
        level++;
        super.visitIndexed(that); 
        level--;
      }
      @Override
      public void visitLabelled(JCLabeledStatement that) {
        pr("Labelled");
        level++;
        super.visitLabelled(that); 
        level--;
      }
      @Override
      public void visitLetExpr(LetExpr that) {
        pr("LetExpr");
        level++;
        super.visitLetExpr(that); 
        level--;
      }
      @Override
      public void visitLiteral(JCLiteral that) {
        pr("Literal",that.toString());
        level++;
        super.visitLiteral(that);
        level--;
      }
      @Override
      public void visitMethodDef(JCMethodDecl that) {
        pr("MethodDef", that.name.toString());
        level++;
        super.visitMethodDef(that);
        level--;
      }
      @Override
      public void visitModifiers(JCModifiers that) {
        pr("Modifires");
        level++;
        super.visitModifiers(that); 
        level--;
      }
      @Override
      public void visitNewArray(JCNewArray that) {
        pr("NewArray");
        level++;
        super.visitNewArray(that); 
        level--;
      }
      @Override
      public void visitNewClass(JCNewClass that) {
        pr("NewClass");
        level++;
        super.visitNewClass(that); 
        level--;
      }
      @Override
      public void visitParens(JCParens that) {
        pr("Parens");
        level++;
        super.visitParens(that); 
        level--;
      }
      @Override
      public void visitReturn(JCReturn that) {
        pr("Return");
        level++;
        super.visitReturn(that); 
        level--;
      }
      @Override
      public void visitSelect(JCFieldAccess that) {
        pr("Select",that.getIdentifier().toString());
        level++;
        super.visitSelect(that); 
        level--;
      }
      @Override
      public void visitSkip(JCSkip that) {
        pr("Skip");
        level++;
        super.visitSkip(that); 
        level--;
      }
      @Override
      public void visitSwitch(JCSwitch that) {
        pr("Switch");
        level++;
        super.visitSwitch(that); 
        level--;
      }
      @Override
      public void visitSynchronized(JCSynchronized that) {
        pr("Synchronized");
        level++;
        super.visitSynchronized(that);
        level--;
      }
      @Override
      public void visitThrow(JCThrow that) {
        pr("Throw");
        level++;
        super.visitThrow(that);
        level--;
      }
      @Override
      public void visitTopLevel(JCCompilationUnit that) {
        pr("TopLevel");
        level++;
        super.visitTopLevel(that);
        level--;
      }
      @Override
      public void visitTree(JCTree that) {
        pr("Tree");
        level++;
        super.visitTree(that); 
        level--;
      }
      @Override
      public void visitTry(JCTry that) {
        pr("Try");
        level++;
        super.visitTry(that); 
        level--;
      }
      @Override
      public void visitTypeApply(JCTypeApply that) {
        pr("TypeApply");
        level++;
        super.visitTypeApply(that); 
        level--;
      }
      @Override
      public void visitTypeArray(JCArrayTypeTree that) {
        pr("TypeArray");
        level++;
        super.visitTypeArray(that); 
        level--;
      }
      @Override
      public void visitTypeBoundKind(TypeBoundKind that) {
        pr("TypeBoundKind");
        level++;
        super.visitTypeBoundKind(that); 
        level--;
      }
      @Override
      public void visitTypeCast(JCTypeCast that) {
        pr("TypeCast");
        level++;
        super.visitTypeCast(that); 
        level--;
      }
      @Override
      public void visitTypeIdent(JCPrimitiveTypeTree that) {
        pr("TypeIdent");
        level++;
        super.visitTypeIdent(that); 
        level--;
      }
      @Override
      public void visitTypeParameter(JCTypeParameter that) {
        pr("TypeParameter");
        level++;
        super.visitTypeParameter(that);
        level--;
      }
      @Override
      public void visitTypeTest(JCInstanceOf that) {
        pr("TypeTest");
        level++;
        super.visitTypeTest(that); 
        level--;
      }
      @Override
      public void visitTypeUnion(JCTypeUnion that) {
        pr("TypeUnion");
        level++;
        super.visitTypeUnion(that); 
        level--;
      }
      @Override
      public void visitUnary(JCUnary that) {
        pr("Unary");
        level++;
        super.visitUnary(that); 
        level--;
      }
      @Override
      public void visitVarDef(JCVariableDecl that) {
        pr("VarDef");
        level++;
        super.visitVarDef(that); 
        level--;
      }
      @Override
      public void visitWhileLoop(JCWhileLoop that) {
        pr("WhileLoop");
        level++;
        super.visitWhileLoop(that); 
        level--;
      }
      @Override
      public void visitWildcard(JCWildcard that) {
        pr("Wildcard");
        level++;
        super.visitWildcard(that); 
        level--;
      }
    });
    return tree;
  }

}
