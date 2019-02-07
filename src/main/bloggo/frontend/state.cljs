(ns bloggo.frontend.state
  (:require [reagent.core :as r]))

(defonce app-state (r/atom {:current-post "- This is content"}))

