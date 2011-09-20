/**
 * 
 */
package org.ikejima.javappp.util;

import java.util.Iterator;

import sun.security.jca.GetInstance;

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
import com.sun.tools.javac.tree.JCTree.JCExpressionStatement;
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
import com.sun.tools.javac.util.List;

/**
 * @author ikeji
 *
 */
public abstract class TraceVisitor extends Visitor {
  
  private void maybeAccept(JCTree t){
    if(t != null){
      t.accept(this);
    }
  }
  
  private void maybeAccept(List<? extends JCTree> list){
    for(JCTree t : list){
      if(t != null) t.accept(this);
    }
  }
  
  @Override
  public void visitAnnotation(JCAnnotation that) {
    maybeAccept(that.getAnnotationType());
    maybeAccept(that.getArguments());
  }
  
  @Override
  public void visitApply(JCMethodInvocation that) {
    maybeAccept(that.getTypeArguments());
    maybeAccept(that.getMethodSelect());
    maybeAccept(that.getArguments());
  }
  
  @Override
  public void visitAssert(JCAssert that) {
    maybeAccept(that.getCondition());
    maybeAccept(that.getDetail());
  }
  
  @Override
  public void visitAssign(JCAssign that) {
    maybeAccept(that.getVariable());
    maybeAccept(that.getExpression());
  }
  
  @Override
  public void visitAssignop(JCAssignOp that) {
    maybeAccept(that.getVariable());
    maybeAccept(that.getExpression());
  }
  
  @Override
  public void visitBinary(JCBinary that) {
    maybeAccept(that.getLeftOperand());
    maybeAccept(that.getRightOperand());
  }
  
  @Override
  public void visitBlock(JCBlock that) {
    maybeAccept(that.getStatements());
  }
  
  @Override
  public void visitBreak(JCBreak that) {
  }
  
  @Override
  public void visitCase(JCCase that) {
    maybeAccept(that.getExpression());
    maybeAccept(that.getStatements());
  }
  
  @Override
  public void visitCatch(JCCatch that) {
    maybeAccept(that.getParameter());
    maybeAccept(that.getBlock());
  }
  
  @Override
  public void visitClassDef(JCClassDecl that) {
    maybeAccept(that.getModifiers());
    maybeAccept(that.getTypeParameters());
    maybeAccept(that.getExtendsClause());
    maybeAccept(that.getImplementsClause());
    maybeAccept(that.getMembers());
  }
  
  @Override
  public void visitConditional(JCConditional that) {
    maybeAccept(that.getCondition());
    maybeAccept(that.getTrueExpression());
    maybeAccept(that.getFalseExpression());
  }
  
  @Override
  public void visitContinue(JCContinue that) {
  }
  
  @Override
  public void visitDoLoop(JCDoWhileLoop that) {
    maybeAccept(that.getStatement());
    maybeAccept(that.getCondition());
  }
  
  @Override
  public void visitErroneous(JCErroneous that) {
    maybeAccept(that.getErrorTrees());
  }
  
  @Override
  public void visitExec(JCExpressionStatement that) {
    maybeAccept(that.getExpression());
  }
  
  @Override
  public void visitForeachLoop(JCEnhancedForLoop that) {
    maybeAccept(that.getVariable());
    maybeAccept(that.getExpression());
    maybeAccept(that.getStatement());
  }
  
  @Override
  public void visitForLoop(JCForLoop that) {
    maybeAccept(that.getCondition());
    maybeAccept(that.getStatement());
    maybeAccept(that.getInitializer());
    maybeAccept(that.getUpdate());
  }
  
  @Override
  public void visitIdent(JCIdent that) {
  }
  
  @Override
  public void visitIf(JCIf that) {
    maybeAccept(that.getCondition());
    maybeAccept(that.getThenStatement());
    maybeAccept(that.getElseStatement());
  }
  
  @Override
  public void visitImport(JCImport that) {
    maybeAccept(that.getQualifiedIdentifier());
  }
  
  @Override
  public void visitIndexed(JCArrayAccess that) {
    maybeAccept(that.getExpression());
    maybeAccept(that.getIndex());
  }
  
  @Override
  public void visitLabelled(JCLabeledStatement that) {
    maybeAccept(that.getStatement());
  }
  
  @Override
  public void visitLetExpr(LetExpr that) {
    maybeAccept(that.defs);
    maybeAccept(that.expr);
  }
  
  @Override
  public void visitLiteral(JCLiteral that) {
  }
  
  @Override
  public void visitMethodDef(JCMethodDecl that) {
    maybeAccept(that.getModifiers());
    maybeAccept(that.getReturnType());
    maybeAccept(that.getTypeParameters());
    maybeAccept(that.getParameters());
    maybeAccept(that.getThrows());
    maybeAccept(that.getBody());
    maybeAccept(that.getDefaultValue());
  }
  
  @Override
  public void visitModifiers(JCModifiers that) {
    maybeAccept(that.getAnnotations());
  }
  
  @Override
  public void visitNewArray(JCNewArray that) {
    maybeAccept(that.getType());
    maybeAccept(that.getDimensions());
    maybeAccept(that.getInitializers());
  }
  
  @Override
  public void visitNewClass(JCNewClass that) {
    maybeAccept(that.getEnclosingExpression());
    maybeAccept(that.getTypeArguments());
    maybeAccept(that.getIdentifier());
    maybeAccept(that.getClassBody());
  }
  
  @Override
  public void visitParens(JCParens that) {
    maybeAccept(that.getExpression());
  }
  
  @Override
  public void visitReturn(JCReturn that) {
    maybeAccept(that.getExpression());
  }
  
  @Override
  public void visitSelect(JCFieldAccess that) {
    maybeAccept(that.getExpression());
  }
  
  @Override
  public void visitSkip(JCSkip that) {
  }
  
  @Override
  public void visitSwitch(JCSwitch that) {
    maybeAccept(that.getExpression());
    maybeAccept(that.getCases());
  }
  
  @Override
  public void visitSynchronized(JCSynchronized that) {
    maybeAccept(that.getExpression());
    maybeAccept(that.getBlock());
  }
  
  @Override
  public void visitThrow(JCThrow that) {
    maybeAccept(that.getExpression());
  }
  
  @Override
  public void visitTopLevel(JCCompilationUnit that) {
    maybeAccept(that.getPackageAnnotations());
    maybeAccept(that.getImports());
    maybeAccept(that.getPackageName());
    maybeAccept(that.getTypeDecls());
  }
  
  @Override
  public void visitTree(JCTree that) {
    assert false;
  }
  
  @Override
  public void visitTry(JCTry that) {
    maybeAccept(that.getBlock());
    maybeAccept(that.getCatches());
    maybeAccept(that.getFinallyBlock());
  }
  
  @Override
  public void visitTypeApply(JCTypeApply that) {
    maybeAccept(that.getType());
    maybeAccept(that.getTypeArguments());
  }
  
  @Override
  public void visitTypeArray(JCArrayTypeTree that) {
    maybeAccept(that.getType());
  }
  
  @Override
  public void visitTypeBoundKind(TypeBoundKind that) {
  }
  
  @Override
  public void visitTypeCast(JCTypeCast that) {
    maybeAccept(that.getType());
    maybeAccept(that.getExpression());
  }
  
  @Override
  public void visitTypeIdent(JCPrimitiveTypeTree that) {
  }
  
  @Override
  public void visitTypeParameter(JCTypeParameter that) {
    maybeAccept(that.getBounds());
  }
  
  @Override
  public void visitTypeTest(JCInstanceOf that) {
    maybeAccept(that.getType());
    maybeAccept(that.getExpression());
  }
  
  @Override
  public void visitTypeUnion(JCTypeUnion that) {
    maybeAccept(that.getTypeAlternatives());
  }
  
  @Override
  public void visitUnary(JCUnary that) {
     maybeAccept(that.getExpression());
  }
  
  @Override
  public void visitVarDef(JCVariableDecl that) {
    maybeAccept(that.getModifiers());
    maybeAccept(that.getType());
    maybeAccept(that.getInitializer());
  }
  
  @Override
  public void visitWhileLoop(JCWhileLoop that) {
    maybeAccept(that.getCondition());
    maybeAccept(that.getStatement());
  }
  
  @Override
  public void visitWildcard(JCWildcard that) {
    maybeAccept(that.getBound());
  }

}
