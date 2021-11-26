package uk.co.alexknight.processingme.exampleapp

import uk.co.alexknight.processingme.exampleapp.TestApp.testAppLogger

object TestMain {

  val app = new TestAppx

  app.setupApplication()
  testAppLogger.LogInformation("TestApp Started")

}
