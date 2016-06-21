androidBuildAar

autoScalaLibrary := false

githubProject := "floatinglabellayout"

javacOptions ++=
    "-source" :: "1.7" ::
    "-target" :: "1.7" ::
    Nil

libraryDependencies ++=
    "com.android.support" % "design" % "24.0.0" ::
    Nil

minSdkVersion := "7"

name := "FloatingLabelLayout"

normalizedName := "floating-label-layout"

organization := "io.taig.android"

platformTarget := "android-23"

publishArtifact in ( Compile, packageDoc ) := false

scalacOptions ++=
    "-deprecation" ::
    "-feature" ::
    Nil

targetSdkVersion := "23"

typedResources := false

version := "1.1.7"