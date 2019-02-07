(ns bloggo.frontend.controllers.editor
  (:require [tuck.core :as t :refer-macros [define-event]]))

(define-event UpdateCurrentPost [post-content]
  {:path [:current-post]}
  post-content)

