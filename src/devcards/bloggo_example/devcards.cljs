(ns bloggo-example.devcards
  (:require [devcards.core :as dc]
            bloggo-example.main.components.input
            bloggo-example.main.components.paginator)
  (:require-macros
   [devcards.core :refer [defcard defcard-rg]]))

(defn main []
  (devcards.core/start-devcard-ui!))

