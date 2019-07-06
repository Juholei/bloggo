(ns bloggo-example.main.components.input
  (:require-macros
   [devcards.core :refer [defcard defcard-rg]])
  (:require [devcards.core :as dc]
            [bloggo.main.components.input :as input]))

(defcard-rg button
  "Button"
  [input/button "text" #(println "on-click")])

