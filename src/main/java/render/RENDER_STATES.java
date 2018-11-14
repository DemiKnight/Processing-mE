package render;

/**
 * The states that would effect how the entity would be rendered.
 * <ul>
 *     <li><tt>halted</tt> -The render should be stopped, next time update() is called </li>
 *     <li><tt>rendering</tt> - Continue to render to the processing window.</li>
 *     <li><tt>hidden</tt> - WIP continue to run "update" but remove from renderList</li>
 * </ul>
 * @see RenderManager
 */
public enum RENDER_STATES {
    halted, //The render should be stopped, next time the update() is ran
    rendering, //Continue to render to the processing window.
    hidden // WIP continue to run "update" but remove from renderList
}
