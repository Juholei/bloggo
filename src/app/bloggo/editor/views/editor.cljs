(ns bloggo.editor.views.editor
  (:require [bloggo.editor.views.components.preview :refer [preview]]
            [bloggo.editor.views.components.input-box :refer [input-box]]
            [bloggo.editor.views.components.button-bar :refer [button-bar]]
            [bloggo.editor.controllers.editor :as ec]
            [reagent.core :as r]))

(defn save-post [e!]
  (e! (ec/->SaveCurrentPost)))

(defn publish-post [e!]
  (e! (ec/->PublishPost)))

(defn editor-buttons [e!]
  [button-bar
   "post-actions"
   [{:text "Save" :on-click (r/partial save-post e!)}
    {:text "Publish" :on-click (r/partial publish-post e!)}]])

(defn editor-page [e! editable-content]
  [:<>
   [editor-buttons e!]
   [:div.editor-container
    [input-box e! editable-content]
    [preview editable-content]]])
