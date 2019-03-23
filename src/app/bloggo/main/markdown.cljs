(ns bloggo.main.markdown
  (:require [markdown-to-hiccup.core :as md]))

(defn markdown->hiccup [markdown]
  (-> markdown
      md/md->hiccup
      md/component))

(defn take-elements
  "Takes produced hiccup and returns n of the first
  elements inside its wrapper div inside a new div"
  [n hiccup]
  (into [:div {}]
        (take n (drop 2 hiccup))))
