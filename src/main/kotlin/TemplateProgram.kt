import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.color.mix
import org.openrndr.draw.FontImageMap
import org.openrndr.draw.loadImage
import org.openrndr.draw.tint
import org.openrndr.shape.Circle


fun main() = application {
    configure {
        width = 1200
        height = 600
    }

    program {
        val image = loadImage("file:data/images/pm5544.png")
        val font = FontImageMap.fromUrl("file:data/fonts/IBMPlexMono-Regular.ttf", 64.0)

        var x = 0.0;

        extend {
            drawer.drawStyle.colorMatrix = tint(ColorRGBa.WHITE.shade(0.2))
            drawer.image(image)

            drawer.fill = ColorRGBa.PINK
            drawer.circle(Math.cos(seconds)*width/2.0+width/2.0, Math.sin(0.5*seconds)*height/2.0 + height/2.0, 140.0)


            val circles = List(500) {
                Circle(Math.random() * width, Math.random() * height, Math.random() * 10.0 + 10.0)
            }
            drawer.circles(circles)

            val redCol = ColorRGBa.PINK
            val greenCol = ColorRGBa.GREEN

            x += 10;

            if(x > width){
                x = 0.0;
            }

            drawer.fill = mix(redCol, greenCol, (Math.cos(seconds) + 1) / 2.0);
            drawer.rectangle(x, height / 2.0, 50.0, 100.0);


            drawer.fontMap = font
            drawer.fill = ColorRGBa.WHITE
            drawer.text("" + seconds, width/2.0, height /2.0)
        }
    }
}

//class Particle{
//
//    constructor(x: Double, y : Double){
//
//    }
//}