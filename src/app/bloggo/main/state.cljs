(ns bloggo.main.state
  (:require [reagent.core :as r]))

(defonce app-state (r/atom {:new-post {:title "Five surprising tips that change everything"
                                       :content "- This is content"}
                            :view :bloggo.main.routes/frontpage}))

