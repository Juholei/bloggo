(ns bloggo-example.main.components.paginator
  (:require-macros
   [devcards.core :refer [defcard defcard-rg]])
  (:require [devcards.core :as dc]
            [bloggo.main.components.paginator :as paginator]))

(defcard-rg paginator
  "Paginator"
  [paginator/paginator 5 12 (constantly "#")])

