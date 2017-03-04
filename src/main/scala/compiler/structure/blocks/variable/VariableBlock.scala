/*
 * Cobalt Programming Language Compiler
 * Copyright (C) 2017  Cobalt
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package compiler.structure.blocks.variable

import compiler.structure.blocks.Block
import compiler.symbol_table.{Row, SymbolTable}
import compiler.utilities.Utils

class VariableBlock(superBlockInit: Block, declaration: Boolean, name: String, varType: String) extends Block(superBlockInit, false, true) {


  SymbolTable.getInstance.addRow(new Row().setId(id).setName(getName).setType(getType).setValue(getValue).setMethodName(Utils.getMethod(this).get.getName).setClassName(Utils.getClass(this).getName))

  override def init() {}

  override def getName: String = name

  override def getValue: String = ""

  override def getType(): String = varType

  override def getOpeningCode: String = {
    if (Utils.getMethod(this) != null) {

      // if integer
      varType match {
        case "int" => asm.visitLdcInsn("new Integer(" + expressions(0).getValue + ")") + asm.visitVarInsn("ISTORE", id)
        case "double" => asm.visitLdcInsn("new Double(" + expressions(0).getValue + ")") + asm.visitVarInsn("DSTORE", id)
        case "float" => asm.visitLdcInsn("new Float(" + expressions(0).getValue + ")") + asm.visitVarInsn("FSTORE", id)
        case "short" => asm.visitLdcInsn("new Short(" + expressions(0).getValue + ")") + asm.visitVarInsn("SASTORE", id)
        case "boolean" => asm.visitLdcInsn("new Boolean(" + expressions(0).getValue + ")") + asm.visitVarInsn("BASTORE", id)
        case default => ""
      }

    } else {
      ""
    }
  }

  override def getClosingCode: String = {
    ""
  }

  override def toString: String = "variable: " + name + " = " + "unknown!" + " " + expressions

}