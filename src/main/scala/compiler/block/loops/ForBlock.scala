package compiler.block.loops

import compiler.block.Block
import compiler.structure.parameters.Parameter

/**
  * Represents a for loop
  *
  * @param superBlockInit
  * @param name
  */
class ForBlock(var superBlockInit: Block, var name: String) extends Block(superBlockInit, true, false) {

  private val params: Array[Parameter] = null

  def getParameters: Array[Parameter] = {
    return params
  }

  def init() {
  }

  def getName: String = {
    return name
  }

  def getValue: String = {
    return null
  }

  def getType: String = ""

  def getOpeningCode: String = {
    return null
  }

  def getClosingCode: String = {
    return null
  }

  override def toString: String = {
    return "for: " + name
  }

}