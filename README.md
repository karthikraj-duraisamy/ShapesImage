# ShapesImage
A library for custom shapes ImageView in Android.


**ShapesImage** is a library for Andrid, which provides custom shaped image views with pre-defined shapes and ability to make own shapes from passing Shape drawables or Vector drawables.

### Highlights of this library

* Highly customizable

    >You can serve any custom shapes through drawables and make your own customized shapes.

* 40+ pre-defined shapes can be used by adding one line extra in your *xml* or *java*.


There are many solutions available to achive custom shapes in andriod. The main goal of this library is to provide minimized code and use the shape drawables or vector drawables to make more shapes by own instead of depending on the limitations in shapes.


### Screenshots:

![Screenshot](/images/screenshots.jpg)


### How to use

>This library has been pushed to *jcenter* repository. So anyone can use the library by just adding the following line in the project dependencies.

```gradle
compile 'net.karthikraj.shapesimage:shapesimage:1.0.2'
```

Just include the following xml snippet to get the pre-defined circular image view.

###### For Pre-defined circle shape:

```xml
<net.karthikraj.shapesimage.ShapesImage xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:orientation="vertical"
    android:layout_width="150dp"
    android:layout_height="150dp"
    android:id="@+id/siListImage"
    android:scaleType="centerCrop"
    android:padding="16dp"
    android:src="@drawable/avatar"
    app:shape="circle"/>
    ```


###### For custom drawable shape:

```xml
<net.karthikraj.shapesimage.ShapesImage xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:orientation="vertical"
    android:layout_width="150dp"
    android:layout_height="150dp"
    android:id="@+id/siListImage"
    android:scaleType="centerCrop"
    android:padding="16dp"
    android:src="@drawable/avatar"
    app:shapeDrawable="@drawable/custom_shape"/>
```

### Using through java:

```java
ShapesImage shapesImage = new ShapesImage(MainActivity.this);
```
Or
```java
ShapesImage shapesImage = (ShapesImage) findViewById(R.id.siListImage);
```

###### For Pre-defined shape:

```java
shapesImage.setImageResource(R.drawable.avatar);
shapesImage.setShapeDrawable(ShapesImage.CIRCLE);```

###### For Custom shape:

```java
shapesImage.setImageResource(R.drawable.avatar);
shapesImage.setShapeDrawable(getResources().getDrawable(R.drawable.custom_shape)
);
```


#### Attributes


**shape** to use the pre-defined shapes.

**shapeDrawable** to use own shape\vector drawable by own.


#### Available shapes

```
app:shape="circle" or ShapesImage.CIRCLE
app:shape="rounded" or ShapesImage.ROUNDED
app:shape="bowl" or ShapesImage.BOWL
app:shape="triangle" or ShapesImage.TRIANGLE
app:shape="cross" or ShapesImage.CROSS
app:shape="ellipse" or ShapesImage.ELLIPSE
app:shape="beaker" or ShapesImage.BEAKER
app:shape="heart" or ShapesImage.HEART
app:shape="xbox" or ShapesImage.XBOX
app:shape="water_drop" or ShapesImage.WATER_DROP
app:shape="video" or ShapesImage.VIDEO
app:shape="twitter_bird" or ShapesImage.TWITTER_BIRD
app:shape="trophy" or ShapesImage.TROPHY
app:shape="tree" or ShapesImage.TREE
app:shape="tooltip" or ShapesImage.TOOLTIP
app:shape="tie" or ShapesImage.TIE
app:shape="thumb_up" or ShapesImage.THUMB_UP
app:shape="thumb_down" or ShapesImage.THUMB_DOWN
app:shape="tennis_ball" or ShapesImage.TENNIS_BALL
app:shape="tag" or ShapesImage.TAG
app:shape="snowman" or ShapesImage.SNOWMAN
app:shape="sheild" or ShapesImage.SHEILD
app:shape="shopping_bag" or ShapesImage.SHOPPING_BAG
app:shape="puzzle" or ShapesImage.PUZZLE
app:shape="octagon" or ShapesImage.OCTAGON
app:shape="message" or ShapesImage.MESSAGE
app:shape="message_reply" or ShapesImage.MESSAGE_REPLY
app:shape="lock" or ShapesImage.LOCK
app:shape="light_bulb" or ShapesImage.LIGHT_BULB
app:shape="leaf" or ShapesImage.LEAF
app:shape="label" or ShapesImage.LABEL
app:shape="heart_broken" or ShapesImage.HEART_BROKEN
app:shape="hexagon" or ShapesImage.HEXAGON
app:shape="guitar_pick" or ShapesImage.GUITAR_PICK
app:shape="ghost" or ShapesImage.GHOST
app:shape="apple" or ShapesImage.APPLE
app:shape="folder" or ShapesImage.FOLDER
app:shape="messenger" or ShapesImage.MESSENGER
app:shape="duck" or ShapesImage.DUCK
app:shape="delete" or ShapesImage.DELETE
app:shape="coffee_mug" or ShapesImage.COFFEE_MUG
app:shape="cloud" or ShapesImage.CLOUD
app:shape="bookmark" or ShapesImage.BOOKMARK
app:shape="bell" or ShapesImage.BELL
app:shape="battery" or ShapesImage.BATTERY
app:shape="apple_logo" or ShapesImage.APPLE_LOGO
app:shape="android" or ShapesImage.ANDROID
```
![Shape List](/images/shapes_list.jpg)
![Shape List two](/images/shapes_list_two.jpg)

###### Shape drawable sample for Circle:

```xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="oval">
    <solid android:color="#000" />
</shape>
```

###### Vector drawable sample for Android Robot:

```xml
<vector xmlns:android="http://schemas.android.com/apk/res/android"
    android:height="100dp"
    android:width="100dp"
    android:viewportWidth="24"
    android:viewportHeight="24">
    <path android:fillColor="#000" android:pathData="M15,5H14V4H15M10,5H9V4H10M15.53,2.16L16.84,0.85C17.03,0.66 17.03,0.34 16.84,0.14C16.64,-0.05 16.32,-0.05 16.13,0.14L14.65,1.62C13.85,1.23 12.95,1 12,1C11.04,1 10.14,1.23 9.34,1.63L7.85,0.14C7.66,-0.05 7.34,-0.05 7.15,0.14C6.95,0.34 6.95,0.66 7.15,0.85L8.46,2.16C6.97,3.26 6,5 6,7H18C18,5 17,3.25 15.53,2.16M20.5,8A1.5,1.5 0 0,0 19,9.5V16.5A1.5,1.5 0 0,0 20.5,18A1.5,1.5 0 0,0 22,16.5V9.5A1.5,1.5 0 0,0 20.5,8M3.5,8A1.5,1.5 0 0,0 2,9.5V16.5A1.5,1.5 0 0,0 3.5,18A1.5,1.5 0 0,0 5,16.5V9.5A1.5,1.5 0 0,0 3.5,8M6,18A1,1 0 0,0 7,19H8V22.5A1.5,1.5 0 0,0 9.5,24A1.5,1.5 0 0,0 11,22.5V19H13V22.5A1.5,1.5 0 0,0 14.5,24A1.5,1.5 0 0,0 16,22.5V19H17A1,1 0 0,0 18,18V8H6V18Z" />
</vector>
```




### Sample

Please see and execute the sample app in this repository.


### Applications using ShapesImage

Please [ping](mailto:raj.karthik777@gmail.com) me or send a pull request if you would like to be added here.
