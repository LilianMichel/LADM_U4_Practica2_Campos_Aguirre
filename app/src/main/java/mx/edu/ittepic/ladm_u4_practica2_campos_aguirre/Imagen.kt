package mx.edu.ittepic.ladm_u4_practica2_campos_aguirre

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint

class Imagen(l: Lienzo,posx : Float, posy : Float, im : Int){
    var x = posx
    var y = posy
    var imagen = BitmapFactory.decodeResource(l.resources,im)
    var invisible = false

    fun pintar(c : Canvas){
        if (invisible == false) {
            c.drawBitmap(imagen, x, y, Paint())
        }
    }

    fun estaEnArea(toqueX : Float, toqueY : Float) : Boolean{
        var x2 = x+imagen.width
        var y2 = y+imagen.height

        if (toqueX >= x && toqueX <= x2){
            if (toqueY >= y && toqueY <= y2){
                return true
            }
        }
        return false
    }
    fun mover(xCoord : Float){
        x = x+(xCoord)
    }
}