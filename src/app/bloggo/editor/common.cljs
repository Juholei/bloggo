(ns bloggo.editor.common)

(defn dom-event->value [event]
  (-> event
      .-target
      .-value))
