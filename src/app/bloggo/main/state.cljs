(ns bloggo.main.state
  (:require [reagent.core :as r]))

(defonce app-state (r/atom {:new-post "- This is content"}))

