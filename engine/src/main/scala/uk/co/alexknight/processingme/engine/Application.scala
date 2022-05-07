package uk.co.alexknight.processingme.engine

import processing.core.PApplet
import uk.co.alexknight.processingme.entities.{EntityManager, StageManager}
import uk.co.alexknight.processingme.render.RenderManager

abstract class Application extends PApplet {
  
  val entityManager: EntityManager = new EntityManager();
  val renderManager: RenderManager = new RenderManager();
  val stageManager: StageManager = new StageManager

}
