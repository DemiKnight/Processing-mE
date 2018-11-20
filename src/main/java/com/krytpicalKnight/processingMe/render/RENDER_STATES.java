package com.krytpicalKnight.processingMe.render;

/**
 * The states that would effect how the entity would be rendered.
 * <ul>
 *     <li><tt>halted</tt> -The com.krytpicalknight.processingMe.render should be stopped, next time update() is called </li>
 *     <li><tt>rendering</tt> - Continue to com.krytpicalknight.processingMe.render to the processing window.</li>
 *     <li><tt>hidden</tt> - WIP continue to run "update" but remove from renderList</li>
 * </ul>
 * @see RenderManager
 */
public enum RENDER_STATES {
    halted, //The com.krytpicalknight.processingMe.render should be stopped, next time the update() is ran
    rendering, //Continue to com.krytpicalknight.processingMe.render to the processing window.
    hidden // WIP continue to run "update" but remove from renderList
}
