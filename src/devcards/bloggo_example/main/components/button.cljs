(ns bloggo-example.main.components.button
  (:require-macros
   [devcards.core :refer [defcard defcard-rg]])
  (:require [devcards.core :as dc]
            [bloggo.main.components.button :refer [button]]
            [reagent.core]))

(defcard-rg button
  "Button"
  [button "text" #(println "on-click")])

