(ns bloggo-example.devcards
  (:require [cljsjs.react]
            [cljsjs.react.dom]
            [devcards.core :as dc]
            bloggo-example.main.components.button
            bloggo-example.main.components.paginator)
  (:require-macros
   [devcards.core :refer [defcard defcard-rg]]))

(defn main []
  (devcards.core/start-devcard-ui!))

