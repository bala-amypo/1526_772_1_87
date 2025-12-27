@Override
public ActivityLog logActivity(Long userId, Long activityTypeId, ActivityLog log) {

    if (log.getActivityDate() == null) {
        throw new ValidationException("Activity date is required");
    }

    if (log.getActivityDate().isAfter(LocalDate.now())) {
        throw new ValidationException("Activity date cannot be in the future");
    }

    if (log.getQuantity() == null || log.getQuantity() <= 0) {
        throw new ValidationException("Quantity must be greater than zero");
    }

    User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));

    ActivityType type = typeRepository.findById(activityTypeId)
            .orElseThrow(() -> new ResourceNotFoundException("Activity type not found"));

    EmissionFactor factor = factorRepository.findByActivityType_Id(activityTypeId)
            .orElseThrow(() -> new ValidationException("No emission factor configured for this activity type"));

    log.setUser(user);
    log.setActivityType(type);
    log.setEstimatedEmission(log.getQuantity() * factor.getFactorValue());

    return logRepository.save(log);
}
