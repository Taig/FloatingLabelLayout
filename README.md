# FloatingLabelLayout

[![CircleCI](https://circleci.com/gh/Taig/floating-label-layout/tree/master.svg?style=shield)](https://circleci.com/gh/Taig/floating-label-layout/tree/master)

> A simple replication of the `TextInputLayout` from the Android design library

## Download

### sbt

```scala
libraryDependencies += "io.taig.android" % "floating-label-layout" % "1.1.8"
```

### Gradle

```groovy
dependencies {
    compile 'io.taig.android:floating-label-layout:1.1.8@aar'
}
```

## Usage

```xml
<io.taig.android.widget.FloatingLabelLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:hint="My label string">

    <RadioGroup ... />

</io.taig.android.widget.FloatingLabelLayout>`
```