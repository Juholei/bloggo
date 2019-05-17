(ns bloggo.editor.views.editor
  (:require [bloggo.editor.views.components.preview :refer [preview]]
            [bloggo.editor.views.components.input-box :refer [input-box]]
            [bloggo.editor.views.components.button-bar :refer [button-bar]]
            [bloggo.editor.controllers.editor :as ec]
            [bloggo.main.common :as c]
            [reagent.core :as r]))

(defn save-post [e!]
  (e! (ec/->SaveCurrentPost)))

(defn publish-post [e!]
  (e! (ec/->PublishPost)))

(defn update-title! [e! event]
  (-> event
      c/dom-event->value
      ec/->UpdateNewPostTitle
      e!))

(defn editor-buttons [e!]
  [button-bar
   "post-actions"
   [{:text "Save" :on-click (r/partial save-post e!)}
    {:text "Publish" :on-click (r/partial publish-post e!)}]])

(defn editor-page [e! {:keys [title content] :as post}]
  [:<>
   [editor-buttons e!]
   [:input {:type :text
            :value title
            :placeholder "Otsikko"
            :on-change (r/partial update-title! e!)}]
   [:div.editor-container
    [input-box e! content]
    [preview content]]])
