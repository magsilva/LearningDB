//
// Generated by JTB 1.3.2
//

package com.ironiacorp.learndb.parser.visitor;
import com.ironiacorp.learndb.parser.syntaxtree.*;
import java.util.*;

/**
 * Provides default methods which visit each node in the tree in depth-first
 * order.  Your visitors may extend this class.
 */
public @SuppressWarnings("all") class GJNoArguDepthFirst<R> implements GJNoArguVisitor<R> {
   //
   // Auto class visitors--probably don't need to be overridden.
   //
   public R visit(NodeList n) {
      R _ret=null;
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
         e.nextElement().accept(this);
         _count++;
      }
      return _ret;
   }

   public R visit(NodeListOptional n) {
      if ( n.present() ) {
         R _ret=null;
         int _count=0;
         for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
            e.nextElement().accept(this);
            _count++;
         }
         return _ret;
      }
      else
         return null;
   }

   public R visit(NodeOptional n) {
      if ( n.present() )
         return n.node.accept(this);
      else
         return null;
   }

   public R visit(NodeSequence n) {
      R _ret=null;
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
         e.nextElement().accept(this);
         _count++;
      }
      return _ret;
   }

   public R visit(NodeToken n) { return null; }

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> Expression()
    * f1 -> ";"
    */
   public R visit(Start n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> AdditiveExpression()
    */
   public R visit(Expression n) {
      R _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> MultiplicativeExpression()
    * f1 -> ( ( "+" | "-" ) MultiplicativeExpression() )*
    */
   public R visit(AdditiveExpression n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> UnaryExpression()
    * f1 -> ( ( "*" | "/" | "%" ) UnaryExpression() )*
    */
   public R visit(MultiplicativeExpression n) {
      R _ret=null;
      n.f0.accept(this);
      n.f1.accept(this);
      return _ret;
   }

   /**
    * f0 -> "(" Expression() ")"
    *       | Identifier()
    *       | MyInteger()
    */
   public R visit(UnaryExpression n) {
      R _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> <IDENTIFIER>
    */
   public R visit(Identifier n) {
      R _ret=null;
      n.f0.accept(this);
      return _ret;
   }

   /**
    * f0 -> <INTEGER_LITERAL>
    */
   public R visit(MyInteger n) {
      R _ret=null;
      n.f0.accept(this);
      return _ret;
   }

}
