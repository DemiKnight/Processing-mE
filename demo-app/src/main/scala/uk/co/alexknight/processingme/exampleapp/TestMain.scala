package uk.co.alexknight.processingme.exampleapp

import processing.core.PApplet
import uk.co.alexknight.processingme.exampleapp.TestApp.testAppLogger

object TestMain extends App {
  val app = new TestApp

  app.setupApplication()
  testAppLogger.LogInformation("TestApp Started")
  PApplet.main(classOf[TestApp])
}
