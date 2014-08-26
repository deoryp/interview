package scott.interview;

import java.util.List;
import java.util.UUID;

public class VectorGraphicDesign {

/*

    Let's say we're developing a vector graphics application.
    It will allow the user to create lines, rectangles, circles, text, etc. and manipulate them independently -
        move them, re-size them, etc. Design an object model for this application.

•	How would you model the representation of the document in an object oriented language?
    -> I would use a simple interface and then I would also provide a abstract implementation
       of it to help reuse code. But if an object was really wacky it could just implement the interface and do whatever
       it needs to do to make it draw-able and editable

•	What classes would you define?
    -> I would define an interface and then the impls of each type of VectorGraphic

•	What methods would you have? What would your API look like?
    -> see VectorGraphic

*/

    // This would be the screen we are drawing on.
    //
    public interface VectorScreen {

        int getWidth();
        int getHeight();

        //
        // lots more methods here. out of scope for the question.
        //
    }

    //
    // Note: it is assumed that because this is a vector graphic application, all the floating point values for x, y, width, and height are % of the final screen. This is why Screen has an int width, height and the vector objects have floats.
    //

    public class Point {
        float x;
        float y;
    }

    /***
     * VectorGraphic is the interface for the minimum amount of control over a vector object to be able to move and draw it.
     *
     * Note: it is assumed that because this is a vector graphic application, all the floating point values for x, y,
     * width, and height are % of the final screen. This is why Screen has an int width, height and the vector objects
     * have floats.
     */
    public interface VectorGraphic {

        /***
         * Get the UUID of the vector object instance, UUID is created in constructor.
         *
         * @return UUID of object
         */
        UUID getUuid();

        /***
         * Move the reference point to a new location
         *
         * @param newPoint The new location
         */
        void position(Point newPoint);

        /***
         * Scale the width and height of the object
         *
         * @param xScale The amount to scale the x direction
         * @param yScale The amount to scale the y direction
         */
        void resize(float xScale, float yScale);

        /***
         * Translate the object relative to itself.
         *
         * @param x The amount to translate the object in the x direction.
         * @param y The amount to translate the object in the y direction.
         */
        void translate(float x, float y);

        /***
         * Rotate the object about the focalPoint
         * @param degree The degree to rotate the object
         * @param focalPoint The point to rotate the object from (Optional)
         */
        void rotation(float degree, Point focalPoint);

        /***
         *  The object would be able to draw itself on the screen, the screen would need some interface
         */
        void draw(VectorScreen screen);
    }

    public abstract class AbstractVectorGraphic implements VectorGraphic {
        private UUID uuid; // UUID of object
        Point location;    // the reference point of the object
        float width;       // the width of the object
        float height;      // the height of the object
        float rotation;    // the rotation of the object

        public AbstractVectorGraphic() {
            uuid = UUID.randomUUID();
        }

        public UUID getUuid() {
            return uuid;
        }
    }

    // lines, rectangles, circles, text, etc would extend from AbstractVectorGraphic and implement the required methods
    // plus anything else that makes them special
    //
    // like:

    public class VectorLines extends AbstractVectorGraphic {

        // todo:: some other member variables might be required here.

        @Override
        public void position(Point newPoint) {
            // todo:: implement me
        }

        @Override
        public void resize(float xScale, float yScale) {
            // todo:: implement me
        }

        @Override
        public void translate(float x, float y) {
            // todo:: implement me
        }

        @Override
        public void rotation(float degree, Point focalPoint) {
            // todo:: implement me
        }

        @Override
        public void draw(VectorScreen screen) {
            // todo:: implement me
        }
    }

    // The document that could hold the stack of vector objects. The idea is they would be drawn from bottom to top
    //
    public class VectorDocument {

        // The object stack to display
        //
        List<VectorGraphic> objects;

        // Would in-queue the new object to the top of the graphics stack
        //
        void addObject(VectorGraphic object) {}

        // Would remove an object that is in the queue by object or by UUID
        //
        void removeObject(VectorGraphic object) {}
        void removeObject(UUID uuid) {}

        // Would try to move the object in a new location in the stack, by object or UUID
        //
        void repositionObject(VectorGraphic object, int position) {}
        void repositionObject(UUID uuid, int position) {}
    }
}
