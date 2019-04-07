(ns bloggo.devcards
  (:require [devcards.core :as dc]
            [reagent.core :as reagent])
  (:require-macros
   [devcards.core :refer [defcard defcard-rg]]))

(defcard-rg rg-example-2
  "some docs"
  [:div "this works"])

(defn main []
  (devcards.core/start-devcard-ui!))

