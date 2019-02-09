(ns bloggo.main.core
  (:require [shadow.loader :as loader]))

(defn init []
  (loader/load "editor"))
