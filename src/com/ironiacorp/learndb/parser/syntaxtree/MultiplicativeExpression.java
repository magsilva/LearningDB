//
// Generated by JTB 1.3.2
//

package com.ironiacorp.learndb.parser.syntaxtree;

/**
 * Grammar production:
 * f0 -> UnaryExpression()
 * f1 -> ( ( "*" | "/" | "%" ) UnaryExpression() )*
 */
public @SuppressWarnings("all") class MultiplicativeExpression implements Node {
   public UnaryExpression f0;
   public NodeListOptional f1;

   public MultiplicativeExpression(UnaryExpression n0, NodeListOptional n1) {
      f0 = n0;
      f1 = n1;
   }

   public void accept(com.ironiacorp.learndb.parser.visitor.Visitor v) {
      v.visit(this);
   }
   public <R,A> R accept(com.ironiacorp.learndb.parser.visitor.GJVisitor<R,A> v, A argu) {
      return v.visit(this,argu);
   }
   public <R> R accept(com.ironiacorp.learndb.parser.visitor.GJNoArguVisitor<R> v) {
      return v.visit(this);
   }
   public <A> void accept(com.ironiacorp.learndb.parser.visitor.GJVoidVisitor<A> v, A argu) {
      v.visit(this,argu);
   }
}

