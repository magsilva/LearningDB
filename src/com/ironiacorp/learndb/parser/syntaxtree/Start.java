//
// Generated by JTB 1.3.2
//

package com.ironiacorp.learndb.parser.syntaxtree;

/**
 * Grammar production:
 * f0 -> Expression()
 * f1 -> ";"
 */
public @SuppressWarnings("all") class Start implements Node {
   public Expression f0;
   public NodeToken f1;

   public Start(Expression n0, NodeToken n1) {
      f0 = n0;
      f1 = n1;
   }

   public Start(Expression n0) {
      f0 = n0;
      f1 = new NodeToken(";");
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
