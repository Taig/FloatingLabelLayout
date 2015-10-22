# FloatingLabelLayout

> A simple replication of the `TextInputLayout` from the Android design library

[![Circle CI](https://circleci.com/gh/Taig/FloatingLabelLayout.svg?style=svg)](https://circleci.com/gh/Taig/FloatingLabelLayout)

## Download

### sbt

````
libraryDependencies += "io.taig.android" % "floating-label-layout" % "1.0.0"
````

### Gradle

````
dependencies {
    compile 'io.taig.android:floating-label-layout:1.0.0@aar'
}
````

## Usage

````xml
<io.taig.android.widget.FloatingLabelLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:hint="My label string">

    <RadioGroup ... />

</io.taig.android.widget.FloatingLabelLayout>`
````