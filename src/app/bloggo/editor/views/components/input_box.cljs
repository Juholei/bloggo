(ns bloggo.editor.views.components.input-box
  (:require [reagent.core :as r]
            [bloggo.editor.controllers.editor :as ec]
            [bloggo.main.common :as c]))

(defn update-post [e! dom-event]
  (-> dom-event
      c/dom-event->value
      ec/->UpdateCurrentPost
      e!))

(defn input-box [e! content]
  [:textarea.editor-sub-view {:style {:resize "none"}
                              :value content
                              :on-change (r/partial update-post e!)}])
