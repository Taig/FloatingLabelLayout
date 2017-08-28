enablePlugins( AndroidLib )

autoScalaLibrary := false

githubProject := "floating-label-layout"

javacOptions ++=
    "-source" :: "1.7" ::
    "-target" :: "1.7" ::
    "-Xlint:deprecation" ::
    Nil

libraryDependencies ++=
    "com.android.support" % "design" % "26.0.1" ::
    Nil

minSdkVersion := "11"

normalizedName := "floating-label-layout"

organization := "io.taig.android"

platformTarget := "android-26"

publishArtifact in ( Compile, packageDoc ) := false

scalacOptions ++=
    "-deprecation" ::
    "-feature" ::
    Nil

typedResources := false

version := "1.2.0"