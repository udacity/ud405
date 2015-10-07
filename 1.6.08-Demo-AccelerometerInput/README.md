# Accelerometer Input

The accelerometer is an incredibly flexible and intuitive way for your user to interact with your game. LibGDX provides access to the acceleromenter readings though 

    Gdx.input.getAccelerometerX();
    Gdx.input.getAccelerometerY();
    Gdx.input.getAccelerometerZ();
    
Regardless of the orientation used by your game, the accelerometer data is reported as though the phone is in portrait orientation, with the positive Z axis coming out of the screen.
 
The accelerometer reports the phone's acceleration in meters per second squared. If the phone is stationary, the only acceleration it's experiencing is the acceleration due to gravity, which is about 9.8 meters per second squared (sounding familiar from physics class?). This means that if the Z axis of the accelerometer is reading 9.8, the phone is flat on it's back. If the Z axis is reading -9.8, the phone is resting on its face. If the Y axis reads 9.8, the phone is upright in the portrait orientation.  

To check these readings out in action, dig into the TODOs.
