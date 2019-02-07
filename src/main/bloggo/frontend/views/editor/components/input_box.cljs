(ns bloggo.frontend.views.editor.components.input-box
  (:require [reagent.core :as r]
            [bloggo.frontend.controllers.editor :as ec]
            [bloggo.frontend.common :as c]))

(defn update-post [e! dom-event]
  (-> dom-event
      c/dom-event->value
      ec/->UpdateCurrentPost
      e!))

(defn input-box [e! content]
  [:textarea.editor-sub-view {:style {:resize "none"}
                              :value content
                              :on-change (r/partial update-post e!)}])
