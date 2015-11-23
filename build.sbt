autoScalaLibrary := false

javacOptions ++=
    "-source" :: "1.7" ::
    "-target" :: "1.7" ::
    Nil

libraryDependencies ++=
    "com.android.support" % "design" % "23.1.1" ::
    Nil

name := "FloatingLabelLayout"

normalizedName := "floating-label-layout"

organization := "io.taig.android"

publishArtifact in ( Compile, packageDoc ) := false

scalaVersion := "2.11.7"

scalacOptions ++=
    "-deprecation" ::
    "-feature" ::
    Nil

version := "1.1.0"