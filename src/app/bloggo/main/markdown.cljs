(ns bloggo.main.markdown
  (:require [markdown-to-hiccup.core :as md]))


(defn markdown->hiccup [markdown]
  (-> markdown
      md/md->hiccup
      md/component))
