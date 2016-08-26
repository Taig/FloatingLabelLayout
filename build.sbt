androidBuildAar

autoScalaLibrary := false

githubProject := "floating-label-layout"

javacOptions ++=
    "-source" :: "1.7" ::
    "-target" :: "1.7" ::
    Nil

libraryDependencies ++=
    "com.android.support" % "design" % "24.2.0" ::
    Nil

minSdkVersion := "7"

normalizedName := "floating-label-layout"

organization := "io.taig.android"

platformTarget := "android-24"

publishArtifact in ( Compile, packageDoc ) := false

scalacOptions ++=
    "-deprecation" ::
    "-feature" ::
    Nil

typedResources := false

version := "1.1.9"